import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-explorer',
  templateUrl: './explorer.component.html',
  styleUrls: ['./explorer.component.css']
})
export class ExplorerComponent implements OnInit {

  fileImagePath = "assets/file.png";
  folderImagePath = "assets/folder.png";

  constructor() { }

  ngOnInit() {
  }

}
