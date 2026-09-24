"""Serve the canned DCIM tree and log every request.

`http.server` is enough for the bytes, but the point here is the log: when a
gallery cell stays blank the first question is whether the request ever arrived.
Absence of a line means the app never sent it; a 404 or a wrong path means it
sent something the tree does not have.
"""

import os
import sys
from http.server import HTTPServer, SimpleHTTPRequestHandler

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)))
PORT = 18080


class LoggingHandler(SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=ROOT, **kwargs)

    def log_message(self, fmt, *args):
        sys.stdout.write("%s  %s\n" % (self.address_string(), fmt % args))
        sys.stdout.flush()

    def do_GET(self):
        path = self.translate_path(self.path)
        hit = "200" if os.path.isfile(path) else "404"
        sys.stdout.write("--> %s %s\n" % (hit, self.path))
        sys.stdout.flush()
        super().do_GET()


if __name__ == "__main__":
    srv = HTTPServer(("0.0.0.0", PORT), LoggingHandler)
    print("serving %s on 0.0.0.0:%d" % (ROOT, PORT))
    sys.stdout.flush()
    srv.serve_forever()
