import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewNotification } from './view-notification';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('ViewNotification', () => {
  let component: ViewNotification;
  let fixture: ComponentFixture<ViewNotification>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewNotification,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewNotification);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
