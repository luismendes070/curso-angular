const xml2js = require('xml2js');

const url: string = 'https://www.localhost:4200/api/cursos';
const path: string = require('./courses.xml');
// const parse: string = path.parse();

const axios = require('axios');

// const url: string = 'https://www.localhost:4200/api/cursos';

axios.get(url).then((response:any) => {
  const res = response.data; // Assuming the XML response is in the 'data' property
  xml2js.parseString(res, (err:any, result:any) => {
     expect(err).to.be.null;
     expect(result).to.have.property('rootElement');
    // additional assertions for response data
  });
});


const data: string =
  '<courses><course category="backend"><id>123456789</id><name>Course Name</name></course><course category="frontend"><id>223456789</id><name>Course Name 2</name></course></courses>';

// parse the XML response
xml2js.parseString(data, (err:any, result:any) => {
  expect(err).to.be.null;
  expect(result).to.have.property('rootElement');
  // additional assertions for response data
});
