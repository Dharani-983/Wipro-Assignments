import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditNotification } from './edit-notification';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('EditNotification', () => {
  let component: EditNotification;
  let fixture: ComponentFixture<EditNotification>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditNotification,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditNotification);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
