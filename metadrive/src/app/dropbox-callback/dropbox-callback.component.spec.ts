import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DropboxCallbackComponent } from './dropbox-callback.component';

describe('DropboxCallbackComponent', () => {
  let component: DropboxCallbackComponent;
  let fixture: ComponentFixture<DropboxCallbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DropboxCallbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DropboxCallbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
