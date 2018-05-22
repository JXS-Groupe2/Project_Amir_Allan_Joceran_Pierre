import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleDriveCallbackComponent } from './google-drive-callback.component';

describe('GoogleDriveCallbackComponent', () => {
  let component: GoogleDriveCallbackComponent;
  let fixture: ComponentFixture<GoogleDriveCallbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoogleDriveCallbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoogleDriveCallbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
