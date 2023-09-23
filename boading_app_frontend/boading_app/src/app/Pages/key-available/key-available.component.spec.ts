import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KeyAvailableComponent } from './key-available.component';

describe('KeyAvailableComponent', () => {
  let component: KeyAvailableComponent;
  let fixture: ComponentFixture<KeyAvailableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KeyAvailableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KeyAvailableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
