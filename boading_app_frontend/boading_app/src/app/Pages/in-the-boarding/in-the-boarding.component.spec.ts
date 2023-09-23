import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InTheBoardingComponent } from './in-the-boarding.component';

describe('InTheBoardingComponent', () => {
  let component: InTheBoardingComponent;
  let fixture: ComponentFixture<InTheBoardingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InTheBoardingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InTheBoardingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
