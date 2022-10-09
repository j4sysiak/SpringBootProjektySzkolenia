import { Directive, AfterViewInit, ElementRef, Input } from '@angular/core';

@Directive({
  selector: '[appBox]'
})
export class BoxDirective implements AfterViewInit {

  @Input()
   size = '1px';

   @Input()
   type = 'solid';

   @Input()
   color = 'red';

  constructor(private elem: ElementRef) {}

  ngAfterViewInit(): void {
    this.elem.nativeElement.style.border = `${this.size} ${this.type} ${this.color}`;
    this.elem.nativeElement.style.borderRadius = '5px';
    this.elem.nativeElement.style.padding = '5px';
    this.elem.nativeElement.style.margin = '5px';
  }

}
