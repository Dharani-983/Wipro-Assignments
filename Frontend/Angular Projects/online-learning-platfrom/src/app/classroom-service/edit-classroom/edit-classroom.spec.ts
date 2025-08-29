import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditClassroom } from './edit-classroom';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('EditClassroom', () => {
  let component: EditClassroom;
  let fixture: ComponentFixture<EditClassroom>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditClassroom,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditClassroom);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
