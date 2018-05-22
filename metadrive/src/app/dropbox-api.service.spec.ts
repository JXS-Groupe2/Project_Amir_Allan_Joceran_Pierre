import { TestBed, inject } from '@angular/core/testing';

import { DropboxApiService } from './dropbox-api.service';

describe('GoogleApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DropboxApiService]
    });
  });

  it('should be created', inject([DropboxApiService], (service: DropboxApiService) => {
    expect(service).toBeTruthy();
  }));
});
