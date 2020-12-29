import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeerKnownComponent } from './beer-known.component';

describe('BeerKnownComponent', () => {
  let component: BeerKnownComponent;
  let fixture: ComponentFixture<BeerKnownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeerKnownComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeerKnownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
