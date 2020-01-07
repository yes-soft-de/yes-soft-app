import { TestBed } from '@angular/core/testing';

import { BlogRepositoryService } from './blog-repository.service';

describe('BlogRepositoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BlogRepositoryService = TestBed.get(BlogRepositoryService);
    expect(service).toBeTruthy();
  });
});
