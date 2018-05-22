import { Component, OnInit } from '@angular/core';
import { SelectedFileDetailsService } from '../selected-file-details.service';
import { BackendApiService } from '../backend-api.service';

@Component({
  selector: 'app-file-details',
  templateUrl: './file-details.component.html',
  styleUrls: ['./file-details.component.css']
})
export class FileDetailsComponent implements OnInit {

  constructor(private selectedFileDetails: SelectedFileDetailsService, private backend: BackendApiService) { }

  ngOnInit() {
  }

  isSelectedFileRemovable() {
    return this.selectedFileDetails.details.type && (this.selectedFileDetails.details.type.valueOf() != "folder");
  }

  removeSelectedFile() {
    var filePathForAPI = this.selectedFileDetails.details.path;
    filePathForAPI = filePathForAPI.substring(1, filePathForAPI.length);
    filePathForAPI += this.selectedFileDetails.details.name;
    
    this.backend.removeFile(filePathForAPI).subscribe(resp => {
      console.log(resp);
    });
  }

}
