import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppCounterComponent } from './app-counter.component';

describe('AppCounterComponent', () => {
  let component: AppCounterComponent;
  let fixture: ComponentFixture<AppCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
