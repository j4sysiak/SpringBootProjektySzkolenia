import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustommDirectiveDemoComponent } from './customm-directive-demo.component';

describe('CustommDirectiveDemoComponent', () => {
  let component: CustommDirectiveDemoComponent;
  let fixture: ComponentFixture<CustommDirectiveDemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustommDirectiveDemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustommDirectiveDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
