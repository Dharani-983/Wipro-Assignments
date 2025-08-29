import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, CommonModule,HttpClientModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
}