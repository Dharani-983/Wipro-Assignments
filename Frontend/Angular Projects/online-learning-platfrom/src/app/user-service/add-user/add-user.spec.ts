import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUser } from './add-user';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideZonelessChangeDetection } from '@angular/core';

describe('AddUser', () => {
  let component: AddUser;
  let fixture: ComponentFixture<AddUser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddUser,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddUser);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
