const jsmockito = require('jsmockito').JsMockito;
const http = require('http');
const server = http.createServer();

describe('Put and Post Requests', () => {
  let request, response;

  beforeEach(() => {
    request = jsmockito.mock(http.IncomingMessage);
    response = jsmockito.mock(http.ServerResponse);
    jsmockito.when(response.writeHead).thenReturn(response);
  });

  it('should handle PUT request', (done) => {
    jsmockito.when(request.method).thenReturn('PUT');
    server.emit('request', request, response);

    setTimeout(() => {
      jsmockito.verify(response.writeHead(200, {'Content-Type': 'text/plain'}));
      jsmockito.verify(response.end('Put request received'));
      done();
    }, 50);
  });

  it('should handle POST request', (done) => {
    jsmockito.when(request.method).thenReturn('POST');
    server.emit('request', request, response);

    setTimeout(() => {
      jsmockito.verify(response.writeHead(200, {'Content-Type': 'text/plain'}));
      jsmockito.verify(response.end('Post request received'));
      done();
    }, 50);
  });
});
