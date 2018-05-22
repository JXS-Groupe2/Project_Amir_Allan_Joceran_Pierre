import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StorageInfoComponent } from './storage-info.component';

describe('StorageInfoComponent', () => {
  let component: StorageInfoComponent;
  let fixture: ComponentFixture<StorageInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StorageInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StorageInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
