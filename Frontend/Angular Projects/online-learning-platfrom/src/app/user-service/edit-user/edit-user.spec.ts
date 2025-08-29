import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditUser } from './edit-user';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('EditUser', () => {
  let component: EditUser;
  let fixture: ComponentFixture<EditUser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditUser,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditUser);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
