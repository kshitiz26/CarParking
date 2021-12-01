import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarparkingListComponent } from './carparking-list.component';

describe('CarparkingListComponent', () => {
  let component: CarparkingListComponent;
  let fixture: ComponentFixture<CarparkingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarparkingListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarparkingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
