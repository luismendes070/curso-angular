import { TestBed } from '@angular/core/testing';

import { XmlService } from './xml.service';

describe('XmlService', () => {
  let service: XmlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(XmlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
