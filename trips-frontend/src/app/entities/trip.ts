export interface Trip{
  name: string;
  description: string;
  tags:string[];
  locations:Location[];
}
export interface Location{
  lat:number;
  lng:number;
  question: string;
  label:string;
}
export function createEmptyTrip():Trip{
 return {
   name:"",
   description:"",
   tags:[],
   locations:[]
 }
}
