import { TestBed } from '@angular/core/testing';

import { SkillRepositoryService } from './skill-repository.service';

describe('SkillRepositoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SkillRepositoryService = TestBed.get(SkillRepositoryService);
    expect(service).toBeTruthy();
  });
});
