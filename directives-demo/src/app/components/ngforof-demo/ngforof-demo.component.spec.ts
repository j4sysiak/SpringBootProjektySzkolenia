import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NgforofDemoComponent } from './ngforof-demo.component';

describe('NgforofDemoComponent', () => {
  let component: NgforofDemoComponent;
  let fixture: ComponentFixture<NgforofDemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NgforofDemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NgforofDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
