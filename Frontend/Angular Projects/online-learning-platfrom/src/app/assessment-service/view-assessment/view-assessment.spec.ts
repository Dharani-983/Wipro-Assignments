import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAssessment } from './view-assessment';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('ViewAssessment', () => {
  let component: ViewAssessment;
  let fixture: ComponentFixture<ViewAssessment>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewAssessment,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewAssessment);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
