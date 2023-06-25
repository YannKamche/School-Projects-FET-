import telnetlib

import time

host = '192.168.56.101'
password='Huawei@123'

tn = telnetlib.Telnet(host)

tn.read_until(b"Password:")
tn.write(password.encode('ascii') + b"\n")
tn.write(b'display cu \n')
time.sleep(1)

print(tn.read_very_eager().decode('ascii'))
tn.close()
