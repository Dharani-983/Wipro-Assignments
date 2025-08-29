import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAssessment } from './edit-assessment';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('EditAssessment', () => {
  let component: EditAssessment;
  let fixture: ComponentFixture<EditAssessment>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditAssessment,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditAssessment);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
