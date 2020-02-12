import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Catalog } from "./catalog.model";

@Injectable({
  providedIn: "root"
})
export class DataService {
  apiUrl = "http://localhost:8081/catalog/userid";

  constructor(private _http: HttpClient) {}

  getCatalogItems() {
    return this._http.get<Catalog[]>(this.apiUrl);
  }
}
