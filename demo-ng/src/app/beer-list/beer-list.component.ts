import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Beer } from '../beer';
import { BeerService } from '../beer.service';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.scss']
})
export class BeerListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name','tagline','link','description', 'image_url','abv','first_brewed'];
  // MatPaginator Inputs
  length = 100;
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  // MatPaginator Output
  pageEvent!: PageEvent;

  private _beers!: Beer[];
  private _dataSource!: MatTableDataSource<Beer>;


  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(private beerService: BeerService) {
    this.dataSource = new MatTableDataSource(<Beer[]>[]);
  }
  ngOnInit(): void {

    this.beerService.findAll().subscribe(data => {
      this.beers = data;
      this.dataSource.data = data;
      // = new MatTableDataSource<Beer>(this.beers);
    });


  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  public get beers(): Beer[] {
    return this._beers;
  }
  public set beers(value: Beer[]) {
    this._beers = value;
  }
  public get dataSource(): MatTableDataSource<Beer> {
    return this._dataSource;
  }
  public set dataSource(value: MatTableDataSource<Beer>) {
    this._dataSource = value;
  }
}
