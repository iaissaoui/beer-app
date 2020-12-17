import { Component, OnInit } from '@angular/core';
import { Beer } from '../beer';
import { BeerService } from '../beer.service';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.scss']
})
export class BeerListComponent implements OnInit {


  private _beers!: Beer[];

  
  constructor(private beersService: BeerService) { }

  ngOnInit(): void {

    this.beersService.findAll().subscribe(data => {
      this.beers = data;
      console.log(this.beers);
    });

  }

  public get beers(): Beer[] {
    return this._beers;
  }
  public set beers(value: Beer[]) {
    this._beers = value;
  }
}
