import { TestBed } from '@angular/core/testing';

import { CarparkingService } from './carparking.service';

describe('CarparkingService', () => {
  let service: CarparkingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarparkingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
