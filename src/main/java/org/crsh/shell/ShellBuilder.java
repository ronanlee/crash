/*
 * Copyright (C) 2003-2007 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.crsh.shell;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class ShellBuilder
{

   /** . */
   private final ShellContext context;

   /** . */
   private final Map<String, Command> commands;

   public ShellBuilder(ShellContext context)
   {
      if (context == null)
      {
         throw new NullPointerException();
      }

      //
      this.context = context;
      this.commands = new HashMap<String, Command>();
   }

   public void addCommand(String name, final JavaCommand command)
   {
      if (name == null)
      {
         throw new NullPointerException();
      }
      if (command == null)
      {
         throw new NullPointerException();
      }
      commands.put(name, command);
   }

   public void addCommand(String name, final String command)
   {
      if (name == null)
      {
         throw new NullPointerException();
      }
      if (command == null)
      {
         throw new NullPointerException();
      }
      commands.put(name, new GroovyCommand(command));
   }

   public Shell build()
   {
      return new Shell(context, commands);
   }
}