import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'shortName'
})
export class ShortNamePipe implements PipeTransform {

  MAX_LENGTH = 15;

  transform(fileName: string): string {
    var newName = fileName;
    if (newName.length > this.MAX_LENGTH) {
      newName = newName.substring(0, this.MAX_LENGTH) + "...";
    }
    return newName;
  }

}
