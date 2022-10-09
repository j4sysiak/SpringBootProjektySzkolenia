import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  bgColor: string;

  ngOnInit() {
    this.bgColor = 'yellowgreen';
  }

  changeBackground(color: string) {
    this.bgColor = color;
  }

  changeBackgroundRandomly() {
    let r = Math.round(Math.random() * 255);
    let g = Math.round(Math.random() * 255);
    let b = Math.round(Math.random() * 255);
    this.bgColor = `rgb(${r}, ${g}, ${b})`;
  }
}
