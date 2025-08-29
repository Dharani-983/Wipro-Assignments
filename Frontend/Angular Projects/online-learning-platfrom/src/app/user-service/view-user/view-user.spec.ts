import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUser } from './view-user';
import { provideZonelessChangeDetection } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('ViewUser', () => {
  let component: ViewUser;
  let fixture: ComponentFixture<ViewUser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewUser,HttpClientTestingModule],
      providers:[provideZonelessChangeDetection()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewUser);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
