import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardingMatesComponent } from './boarding-mates.component';

describe('BoardingMatesComponent', () => {
  let component: BoardingMatesComponent;
  let fixture: ComponentFixture<BoardingMatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoardingMatesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardingMatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
