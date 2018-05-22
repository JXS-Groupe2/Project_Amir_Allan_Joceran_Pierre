import { Component, OnInit } from '@angular/core';
import { BackendApiService } from '../backend-api.service';
import { SelectedFileDetailsService } from '../selected-file-details.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-explorer',
  templateUrl: './explorer.component.html',
  styleUrls: ['./explorer.component.css']
})
export class ExplorerComponent implements OnInit {

  fileImagePath = "assets/file.png";
  folderImagePath = "assets/folder.png";
  currentPath = "/";
  files: Object;

  constructor(private backend: BackendApiService, private selectedFileDetails: SelectedFileDetailsService, private http: HttpClient) { }

  ngOnInit() {
    // TODO : récupérer la liste via l'API du back-end
    this.http.get("assets/exampleFileList.json").subscribe(data => {
      this.files = data;
    });
    
    this.backend.getFiles().subscribe(resp => {
      console.log(resp);
      //this.files = JSON.parse(resp.body);
    });
  }

  isFolder(file) {
    return file.fileType == "folder";
  }

  setSelectedFileDetails(file) {
    this.selectedFileDetails.details = {
      name: file.name,
      origin: file.origin.key,
      type: file.fileType,
      size: file.size,
      path: this.currentPath
    }
  }

}
