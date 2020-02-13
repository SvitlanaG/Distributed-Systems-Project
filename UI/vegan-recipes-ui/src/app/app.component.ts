import { DataService } from "./data.service";
import { Catalog } from "./catalog.model";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent implements OnInit {
  title = "vegan-recipes-ui";
  catalogItems$: Catalog[];
  max: number = 5;
  rate: number;
  isReadonly: boolean = true;

  constructor(private dataService: DataService) {}

  ngOnInit() {
    return this.dataService
      .getCatalogItems()
      .subscribe(data => (this.catalogItems$ = data));
  }
}
