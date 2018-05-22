import { TestBed, inject } from '@angular/core/testing';

import { SelectedFileDetailsService } from './selected-file-details.service';

describe('SelectedFileDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SelectedFileDetailsService]
    });
  });

  it('should be created', inject([SelectedFileDetailsService], (service: SelectedFileDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
