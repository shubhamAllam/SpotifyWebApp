import { TestBed } from '@angular/core/testing';

import { PlaylistGuardGuard } from './playlist-guard.guard';

describe('PlaylistGuardGuard', () => {
  let guard: PlaylistGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(PlaylistGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
