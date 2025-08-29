import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCourse } from './view-course';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('ViewCourse', () => {
  let component: ViewCourse;
  let fixture: ComponentFixture<ViewCourse>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewCourse,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewCourse);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
