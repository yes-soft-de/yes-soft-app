import { TestBed } from '@angular/core/testing';

import { ServiceRepositoryService } from './service-repository.service';

describe('ServiceRepositoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServiceRepositoryService = TestBed.get(ServiceRepositoryService);
    expect(service).toBeTruthy();
  });
});
