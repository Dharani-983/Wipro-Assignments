import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRoute } from './view-route';

describe('ViewRoute', () => {
  let component: ViewRoute;
  let fixture: ComponentFixture<ViewRoute>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewRoute]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRoute);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
