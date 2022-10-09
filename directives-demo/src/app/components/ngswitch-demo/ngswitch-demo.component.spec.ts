import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NgswitchDemoComponent } from './ngswitch-demo.component';

describe('NgswitchDemoComponent', () => {
  let component: NgswitchDemoComponent;
  let fixture: ComponentFixture<NgswitchDemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NgswitchDemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NgswitchDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
