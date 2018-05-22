import { Injectable } from '@angular/core';

@Injectable()
export class SelectedFileDetailsService {

  details = {
    name: "",
    origin: "",
    type: "",
    size: "",
    path: ""
  }

  constructor() { }

}
