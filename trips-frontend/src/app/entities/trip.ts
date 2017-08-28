export interface Trip{
  id:number;
  name: string;
  description: string;
}
export interface Location{
  lat:number;
  lng:number;
  question: string;
  label:string;
  description:string;
}

export function createEmptyTrip():Trip{
 return {
   id:0,
   name:"",
   description:"",
 }
}
