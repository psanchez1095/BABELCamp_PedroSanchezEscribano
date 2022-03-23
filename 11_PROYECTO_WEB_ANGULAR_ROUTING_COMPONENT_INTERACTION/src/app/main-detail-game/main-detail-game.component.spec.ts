import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainDetailGameComponent } from './main-detail-game.component';

describe('MainDetailGameComponent', () => {
  let component: MainDetailGameComponent;
  let fixture: ComponentFixture<MainDetailGameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainDetailGameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MainDetailGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
