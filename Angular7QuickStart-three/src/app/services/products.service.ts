import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  //products: Array<any>;

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<any> {
    return this.http.get('http://localhost:4300/products/');
  }

  //  getProductById(id: number): any {
  //    return this.products.find(p=>p.ID===id);
  //  }

}
