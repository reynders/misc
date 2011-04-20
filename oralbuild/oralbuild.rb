require 'open-uri'

old_status = ""

while true do
  current_status = open("http://radiator.url.here").read.scan(/<div class="subsystem ([^>]*)">[^<]*<div[^<]*<h3[^<]*<a[^>]*>Our Components</m)[0][0]
  if current_status != old_status
    command = "echo build " + current_status.to_s + " | espeak"
    puts "Command is #{command}"
    system(command)
    old_status = current_status
  end
  
  sleep 10
end
