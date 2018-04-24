import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicesAuthComponent } from './services-auth.component';

describe('ServicesAuthComponent', () => {
  let component: ServicesAuthComponent;
  let fixture: ComponentFixture<ServicesAuthComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServicesAuthComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicesAuthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
