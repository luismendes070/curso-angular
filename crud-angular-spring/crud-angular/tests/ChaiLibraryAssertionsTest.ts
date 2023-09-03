import * as chai from 'chai';
import chaiHttp = require('chai-http');

const url: string = "https://www.localhost:4200/api/cursos";
const path: string = require("./courses.xml");
// const parse: string = path.parse();
const data: string = '<courses><course category="backend"><id>123456789</id><name>Course Name</name></course><course category="frontend"><id>223456789</id><name>Course Name 2</name></course></courses>';

chai.use(chaiHttp);

chai
  .request(url)
  .put(path)
  .send(data)
  .end((err, res) => {
    expect(err).to.be.null;
    expect(res).to.have.status(200);
    // additional assertions for response data
  });

  chai
    .request(url)
    .post(path)
    .send(data)
    .end((err, res) => {
      expect(err).to.be.null;
      expect(res).to.have.status(201);
      // additional assertions for response data
    });
