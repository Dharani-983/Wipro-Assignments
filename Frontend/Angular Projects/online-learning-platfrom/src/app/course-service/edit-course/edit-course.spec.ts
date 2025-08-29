import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCourse } from './edit-course';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('EditCourse', () => {
  let component: EditCourse;
  let fixture: ComponentFixture<EditCourse>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditCourse,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCourse);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
